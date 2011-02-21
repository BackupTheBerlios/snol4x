package de.fractalqb.snol4x

trait StdLogging
{
	protected val componentPath: String
	lazy val component: Category = Component( componentPath )
	
	lazy val LOGinfo = Logger( Topic.INFO, component )
	lazy val LOGtrace = Logger( Topic.TRACE, component )
	lazy val LOGdebug = Logger( Topic.DEBUG, component )
	
	lazy val LOGwarn = Logger( Priority UNIMPORTANT, Topic.PROBLEM, component )
	lazy val LOGerror = Logger( Priority.NORMAL, Topic PROBLEM, component )
	lazy val LOGfatal = Logger( Priority.IMPORTANT, Topic PROBLEM, component )
}


object StdLogging
{
	def pathFor[T]( implicit mT: Manifest[T] ): String = mT.erasure.getName
}