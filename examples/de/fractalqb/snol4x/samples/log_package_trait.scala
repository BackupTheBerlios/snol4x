package de.fractalqb.snol4x.samples

import de.fractalqb.snol4x._

object Log extends StdLogging {
	override val componentPath = "de.fractalqb.snol4x.samples"
	
	def main( args: Array[String] ) {
		LOGtrace( Priority NORMAL )( "doing fine" )
		LOGwarn( "The end is near!" )
	}
}
