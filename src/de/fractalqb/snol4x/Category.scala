package de.fractalqb.snol4x

abstract class Category( val name: String,
						 var prioThrh: Short )
  extends Equals
{
  private var subs = Set.empty[SubCategory]

  def path: String
  def facet: Facet

  def has( name: String ): Option[SubCategory] =
	subs.find( _.name == name )

  def get( name: String ): SubCategory =
	has( name ) match {
	  case Some(cat) => cat
	  case None => {
		val cat = new SubCategory( this, name )
		subs += cat
		cat
	  }
	}

  def apply( path: Seq[String] ): Category =
	(this /: path) { (c, n) => c.get( n ) }

  def apply( pathStr: String, sep: String = "\\." ): Category =
	this( pathStr split sep )

  override def canEqual( that: Any ): Boolean =
	that.isInstanceOf[Category]

  override def equals( that: Any ): Boolean =
	if ( canEqual( that ) ) name == that.asInstanceOf[Category].name
	else false
}
