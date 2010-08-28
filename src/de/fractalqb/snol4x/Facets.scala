package de.fractalqb.snol4x

class Facet private ( name: String,
		              prioThrh: Short )
  extends Category( name, prioThrh )
{
  override def path: String = name + ':'
  override def facet: Facet = this
}


object Facet {

  def apply( name: String ): Facet =
	facs.find( _.name == name ) match {
	  case Some(f) => f
	  case None => {
		val newf = new Facet( name, 0 )
		facs += newf
		newf
	  }
	}

  def all = facs

  private var facs = Set.empty[Facet]

  lazy val COMPONENT = this( "component" )
  lazy val TOPIC = this( "topic" )
}


object Component {
  def apply( path: Seq[String] ) =
	Facet.COMPONENT( path )

  def apply( pathStr: String, sep: String = "\\." ) =
	Facet.COMPONENT( pathStr, sep )
}

object Topic {
	val INFO =  Facet.TOPIC( "info" )
	val TRACE = INFO get "trace"
	val DEBUG = INFO get "debug"
	val PROBLEM = Facet.TOPIC( "problem" )
}
