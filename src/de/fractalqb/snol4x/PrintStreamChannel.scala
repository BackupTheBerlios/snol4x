package de.fractalqb.snol4x

import java.text.SimpleDateFormat
import java.io.PrintStream

object PrintStreamChannel {
	lazy val OUT = new PrintStreamChannel( System.out )
	lazy val ERR = new PrintStreamChannel( System.err )
}

class PrintStreamChannel( val os: PrintStream ) extends Channel {
	
	override def send( cats: Seq[Category], timestamp: Long, form: String, args: Array[Any] ) {
		os.append( dtfm.format( timestamp ) ).append( ':' )
		cats.foreach { c => os.append( '[' + c.path + ']' ) }
		os.append( ':' ).append( form.format( args: _* ) ).println
	}
	
	override def equals( that: Any ): Boolean = that match {
		case psc: PrintStreamChannel => this.os == psc.os
		case _ => false
	}
	
	private val dtfm = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss.SSS" )
}
