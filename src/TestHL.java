class TestHL {

    private static SimpleCharStream instream;
    private static HLTokenManager scanner;
    private static HL parser;
    private static HLEval evaluator;
     
    public static void main(String args[]) {

		// Figure out input stream from args or stdin
		java.io.InputStream infile;
		if (args.length < 1) {
	 		infile = System.in;
		} 
		else try {  
	  		infile = new java.io.FileInputStream(args[0]);
		} catch (java.io.FileNotFoundException e) {
	   		System.out.println("File " + args[0] + " not found."); 
	   		return;
		} 

		// Create scanner, parser, and evaluator
		instream = new SimpleCharStream(infile);
		scanner = new HLTokenManager(instream);
		parser = new HL(scanner);
		evaluator = new HLEval();   

		// Call parse-eval until EOF reached
		while (nextParse());
    }

    private static boolean nextParse() {
		  SimpleNode tree;
		  Object value;

		  try {
        tree = parser.start();
  		  // tree.dump("");  // Uncomment to display  AST
			  if (tree == null)	return true;
             
        // Evaluate non-null tree
			  value = tree.jjtAccept(evaluator,null);
			  if (value!=null)  System.out.println(value);
        
      // Handle EOF
		  } catch (ParseException e) {
        if (!e.getMessage().contains("EOF") && !e.getMessage().contains("End of File"))
          System.out.println("Syntax error: " + e +". Try recompiling with DEBUG_PARSER=true");
        return false;

      // Handle visitor exceptions
		  } catch (Exception e) {
			  System.out.println(e);
		  }
		  return true;
	  }

}
