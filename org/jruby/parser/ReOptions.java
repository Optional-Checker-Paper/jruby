/*
 * ReOptions.java - No description
 * Created on 10. September 2001, 17:51
 * 
 * Copyright (C) 2001 Jan Arne Petersen, Stefan Matthias Aust
 * Jan Arne Petersen <japetersen@web.de>
 * Stefan Matthias Aust <sma@3plus4.de>
 * 
 * JRuby - http://jruby.sourceforge.net
 * 
 * This file is part of JRuby
 * 
 * JRuby is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * JRuby is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with JRuby; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 * 
 */
package org.jruby.parser;

public interface ReOptions {
    int RE_OPTION_IGNORECASE   = 1;
    int RE_OPTION_EXTENDED     = (RE_OPTION_IGNORECASE << 1);
    int RE_OPTION_MULTILINE    = (RE_OPTION_EXTENDED   << 1);
    int RE_OPTION_SINGLELINE   = (RE_OPTION_MULTILINE  << 1);
    int RE_OPTION_POSIXLINE    = (RE_OPTION_MULTILINE | RE_OPTION_SINGLELINE);
    int RE_OPTION_LONGEST      = (RE_OPTION_SINGLELINE << 1);
    int RE_MAY_IGNORECASE      = (RE_OPTION_LONGEST    << 1);
}
