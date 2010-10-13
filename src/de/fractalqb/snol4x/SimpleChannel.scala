package de.fractalqb.snol4x

import java.text.SimpleDateFormat
object SimpleChannel extends Channel {
	override def send( cats: Seq[Category], timestamp: Long, form: String, args: Any* ) {
		System.err.append( dtfm.format( timestamp ) ).append( ':' )
		cats.foreach { c => System.err.append( '[' + c.path + ']' ) }
		System.err.append( ':' )
				  .append( form.format( args ) )
				  .println
	}
	
	private val dtfm = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss.SSS" )
}
