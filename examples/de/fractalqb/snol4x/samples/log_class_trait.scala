package de.fractalqb.snol4x.samples

import de.fractalqb.snol4x._

object SomeClass extends StdLogConfig {
	override val componentPath = StdLogConfig pathFor classOf[SomeClass]
	
	def main( args: Array[String] ) {
		val instance = new SomeClass
		instance.fun()
	}
}

class SomeClass {
	def fun() {
		SomeClass.trace( Priority NORMAL )( "fun() was called" )
	}
}
