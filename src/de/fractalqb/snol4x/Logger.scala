package de.fractalqb.snol4x

class Logger( cat: Category, moreCats: Seq[Category] ) {
  // TODO: Accept each facet only once!
  val cats = Array( cat ) ++ moreCats
  var prioThreshold: Short = cats.map( _.prioThreshold ).min
  cats.foreach( _.logrs += this )
  
  def apply( prio: Short )( form: String, args: Any* ) {
	cats foreach { c => println( c.path ) }
	System.err.println( form format args )
  }
}

object Logger {
	def apply( cat: Category, moreCats: Category* ) =
		new Logger( cat, moreCats )
	
	def apply( prioThreshold: Short, cat: Category, moreCats: Category* ) =
		(new Logger( cat, moreCats ))( prioThreshold )_
}