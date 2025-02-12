package org.jruby.ir.targets.indy;

import com.headius.invokebinder.Binder;
import org.jruby.Ruby;
import org.jruby.runtime.ThreadContext;
import org.jruby.runtime.opto.Invalidator;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Opcodes;

import java.lang.invoke.CallSite;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.MutableCallSite;
import java.lang.invoke.SwitchPoint;

import static java.lang.invoke.MethodHandles.lookup;
import static java.lang.invoke.MethodType.methodType;
import static org.jruby.util.CodegenUtils.p;

public class CheckpointSite extends MutableCallSite {
    public static final Handle CHECKPOINT_BOOTSTRAP = new Handle(
            Opcodes.H_INVOKESTATIC,
            p(CheckpointSite.class),
            "checkpointBootstrap",
            Bootstrap.BOOTSTRAP_BARE_SIG,
            false);

    public CheckpointSite(MethodType type) {
        super(type);
    }

    public static CallSite checkpointBootstrap(MethodHandles.Lookup lookup, String name, MethodType type) throws Throwable {
        CheckpointSite site = new CheckpointSite(type);
        MethodHandle handle = lookup.findVirtual(CheckpointSite.class, "checkpointFallback", methodType(void.class, ThreadContext.class));

        handle = handle.bindTo(site);
        site.setTarget(handle);

        return site;
    }

    public void checkpointFallback(ThreadContext context) throws Throwable {
        Ruby runtime = context.runtime;
        Invalidator invalidator = runtime.getCheckpointInvalidator();

        MethodHandle target = Binder
                .from(void.class, ThreadContext.class)
                .nop();
        MethodHandle fallback = lookup().findVirtual(CheckpointSite.class, "checkpointFallback", methodType(void.class, ThreadContext.class));
        fallback = fallback.bindTo(this);

        target = ((SwitchPoint)invalidator.getData()).guardWithTest(target, fallback);

        this.setTarget(target);

        // poll for events once since we've ended up back in fallback
        context.pollThreadEvents();
    }
}
