/* Generated By:JJTree: Do not edit this line. ASTfn_call.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTfn_call extends SimpleNode {
  public ASTfn_call(int id) {
    super(id);
  }

  public ASTfn_call(HL p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(HLVisitor visitor, Object data) throws Exception {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=44332f191d2eb4ea2aea1e1d06c3c9bc (do not edit this line) */
