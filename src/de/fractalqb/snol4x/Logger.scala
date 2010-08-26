package de.fractalqb.snol4x

class Logger( cat: Category, moreCats: Category* ) {
  // TODO: Accept each facet only once!
  val cats = Array( cat ) ++ moreCats
  var prioThreshold: Short = cats.map( _.prioThreshold ).min
  cats.foreach( _.logrs += this )
  
  def apply( prio: Short, form: String, args: Any* ) {
	cats foreach { c => println( c.path ) }
  }
}
