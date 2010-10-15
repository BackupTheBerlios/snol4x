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
	import SomeClass.trace
	def fun() {
		trace( Priority NORMAL )( "fun(%2$d) was called %1$d times", 7, 1 )
	}
}
