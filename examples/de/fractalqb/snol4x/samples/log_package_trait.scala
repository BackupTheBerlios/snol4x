package de.fractalqb.snol4x.samples

import de.fractalqb.snol4x._

object Log extends StdLogConfig {
	override val componentPath = "de.fractalqb.snol4x.samples"
	
	def main( args: Array[String] ) {
		Log.trace( Priority NORMAL )( "doing fine" )
		Log.warn( "The end is near!" )
	}
}
