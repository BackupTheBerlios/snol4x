package de.fractalqb.snol4x.samples

import de.fractalqb.snol4x._

object LogConv {
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
		LogConv.trace( Priority NORMAL )( "doing fine" )
		LogConv.warn( "The end is near!" )
	}
}
