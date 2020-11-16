package org.jruby.ast.visitor;

import org.jruby.RubySymbol;
import org.jruby.ast.CallNode;
import org.jruby.ast.Node;

public class OperatorCallNode extends CallNode {
    public OperatorCallNode(int line, Node receiverNode, RubySymbol name, Node argsNode, Node iterNode, boolean isLazy) {
        super(line, receiverNode, name, argsNode, iterNode, isLazy);
    }
}
