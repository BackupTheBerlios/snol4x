package de.fractalqb.snol4x

trait StdLogging
{
	protected val componentPath: String
	lazy val component: Category = Component( componentPath )
	
	lazy val info = Logger( Topic.INFO, component )
	lazy val trace = Logger( Topic.TRACE, component )
	lazy val debug = Logger( Topic.DEBUG, component )
	
	lazy val warn = Logger( Priority UNIMPORTANT, Topic.PROBLEM, component )
	lazy val error = Logger( Priority.NORMAL, Topic PROBLEM, component )
	lazy val fatal = Logger( Priority.IMPORTANT, Topic PROBLEM, component )
}


object StdLogging
{
	def pathFor[T]( implicit mT: Manifest[T] ): String = mT.erasure.getName
}