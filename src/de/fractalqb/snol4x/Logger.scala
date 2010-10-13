package de.fractalqb.snol4x

import scala.collection.mutable
import scala.collection.immutable.SortedMap;

class Logger( cat: Category, moreCats: Seq[Category] ) {
	// TODO: Accept each facet only once!
	val cats = (List(cat) ++ moreCats).toArray;
	var prioth: Short = 0
	var chans = SortedMap.empty[Short, List[Channel]]
	reconf()

	def apply( prio: Short )( form: String, args: Any* ) {
		val ts = System.currentTimeMillis
		if ( prio >= prioth ) {
			for ( (_, cs) <- chans.rangeImpl( Some(prio), None ) )
				cs.foreach { _.send( cats, ts, form, args ) }
		}
	}
	
	private def reconf() {
		chans += (0.asInstanceOf[Short] -> List(SimpleChannel))
//		val facetChans = mutable.Map.empty[Channel,Short]
//		for ( val cat <- cats ) {
//			for ( )
//		}
	}
}

object Logger {
	def apply( cat: Category, moreCats: Category* ) =
		new Logger( cat, moreCats )

	def apply( prioThreshold: Short, cat: Category, moreCats: Category* ) =
		(new Logger( cat, moreCats ))( prioThreshold )_
}
