package de.fractalqb.snol4x.samples

import de.fractalqb.snol4x._

object Log {
	val trace = Logger( Topic TRACE,
			            Component( "de.fractalqb.snol4x.samples" ) )
	val warn = Logger( Priority UNIMPORTANT,
					   Topic PROBLEM,
			           Component( "de.fractalqb.snol4x.samples" ) )
	val error = Logger( Priority NORMAL,
			            Topic PROBLEM,
			            Component( "de.fractalqb.snol4x.samples" ) )
	val fatal = Logger( Priority IMPORTANT,
			            Topic PROBLEM,
			            Component( "de.fractalqb.snol4x.samples" ) )

	def main( args: Array[String] ) {
		Log.trace( Priority.NORMAL )( "doing fine" )
		Log.warn( "The end is near!" )
	}
}
