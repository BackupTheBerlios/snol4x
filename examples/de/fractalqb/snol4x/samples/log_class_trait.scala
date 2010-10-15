package de.fractalqb.snol4x.samples

import de.fractalqb.snol4x._

object SomeClass extends StdLogConfig {
	override val componentPath = StdLogConfig.pathFor[SomeClass]
	
	def main( args: Array[String] ) {
		val instance = new SomeClass
		instance.fun()
	}
	
	private var funCounter = 0
}

class SomeClass {
	import SomeClass.debug
	val trace = SomeClass.trace( Priority NORMAL )_
	def fun() {
		SomeClass.funCounter += 1
		trace( "fun(%2$d) was called %1$d times", SomeClass.funCounter, 42 )
		debug( Priority IRRELEVANT )( "There's nothing to debug, here!" )
	}
}
