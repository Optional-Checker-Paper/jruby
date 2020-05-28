exclude :test_error_def_in_argument, "provides different syntax errors"
exclude :test_invalid_char, "needs investigation"
exclude :test_lparenarg, "space issue with parens in really weird syntax"
exclude :test_literal_in_conditional, "flip-flop case raises because do not implement flip-flop"
exclude :test_location_of_invalid_token, "not implemented, #6159"
exclude :test_method_block_location, "needs investigation"
exclude :test_method_location_in_rescue, "parser updates corrected defs to use first line"
exclude :test_negative_line_number, "only backtrace is wrong from linenum instr getting wrong number"
exclude :test_question, "needs investigation"
exclude :test_rescue_in_command_assignment, "needs investigation"
exclude :test_string, "lots of very specific error messages in which we differ a little"
exclude :test_symbol, "we should allow empty unicode escapes that not really"
exclude :test_truncated_source_line, "2.5 truncates long source lines...we dont yet"
exclude :test_unexpected_token_after_numeric, "More strict parsing of text immediately after numbers"
exclude :test_unused_variable, "missing warning in parser (#2147)"
exclude :test_void_expr_stmts_value, "1; next; 2 is figured via compile.c.  IR can do equivalent for 9k.  Not a huge issue for 1.7.x barring real issue"
exclude :test_whitespace_warning, "not implemented, #6159"

