/* Generated By:JJTree: Do not edit this line. ASTReturn.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTReturn extends SimpleNode {
  public ASTReturn(int id) {
    super(id);
  }

  public ASTReturn(HL p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(HLVisitor visitor, Object data) throws Exception {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=d92f440309ba9ed691ba17ae764d6b69 (do not edit this line) */