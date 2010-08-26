package de.fractalqb.snol4x

class Logger( cat: Category, moreCats: Category* ) {
  val cats = Array( cat ) ++ moreCats

  def apply( prio: Short, form: String, args: Any* ) {
	cats foreach { c => println( c.path ) }
  }
}
