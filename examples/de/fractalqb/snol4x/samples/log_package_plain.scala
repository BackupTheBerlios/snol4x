package de.fractalqb.snol4x.samples

import de.fractalqb.snol4x._

object LogPlain {
	val trace = Logger( Facet( "topic" )( "info.trace" ), // topic:info.trace
			            // component:de.fractalqb.snol4x.samples
			            Facet( "component" )( "de.fractalqb.snol4x.samples" ) )
	val warn = Logger( -16383: Short, // a fairly low priority
					   Facet( "topic" )( "problem" ), // topic:problem
			           Facet( "component" )( "de.fractalqb.snol4x.samples" ) )
	val error = Logger( 0: Short, // the middle of priorities
					    Facet( "topic" )( "problem" ), // topic:problem
			            Facet( "component" )( "de.fractalqb.snol4x.samples" ) )
	val fatal = Logger( 16383: Short, // a higher priority
					    Facet( "topic" )( "problem" ), // topic:problem
			            Facet( "component" )( "de.fractalqb.snol4x.samples" ) )

	def main( args: Array[String] ) {
		LogPlain.trace( Priority.NORMAL )( "doing fine" )
		LogPlain.warn( "The end is near!" )
	}
}
