package de.fractalqb.snol4x

import scala.collection.mutable
import scala.collection.immutable.SortedMap;

class Logger( cat: Category, moreCats: Seq[Category] )
{
	val cats = Logger.uniqFacets( cat, moreCats )
	var minPrio: Short = 0	//< priority threshold
	var chans = SortedMap.empty[Short, List[Channel]]
	reconf()

	def apply( prio: Short )( form: String, args: Any* ) {
		if ( prio >= minPrio ) {
			val ts = System.currentTimeMillis
			for ( (_, cs) <- chans.rangeImpl( Some(prio), None ) )
				cs.foreach { _.send( cats, ts, prio, form, args.toArray ) }
		}
	}
	
	private[snol4x] def reconf() {
		// take the minimum threshold per channel from each path
		val minThByChan = mutable.Map.empty[Channel, Short]
		for ( cat <- cats;
			  thByChan = Logger.chansWithPrio( cat );
			  (chan, th) <- thByChan )
		{
			minThByChan.get( chan ) match {
				case Some(minTh) => if ( th < minTh )
										minThByChan.put( chan, th )
				case None => minThByChan.put( chan, th )
			}
		}

		minPrio = java.lang.Short.MAX_VALUE
		for ( (chan, th) <- minThByChan ) {
			if ( th < minPrio )
				minPrio = th
			chans.get( th ) match {
			case Some(chanLs) => chans += (th -> (chan :: chanLs))
			case None => chans += (th -> List(chan))
			}
		}
	}
}


object Logger
{	
	def apply( cat: Category, moreCats: Category* ) =
		new Logger( cat, moreCats )

	def apply( prioThreshold: Short, cat: Category, moreCats: Category* ) =
		(new Logger( cat, moreCats ))( prioThreshold )_
		
	private def uniqFacets( cat: Category, moreCats: Seq[Category] ): Array[Category] = {
		var res = List( cat )
		for ( cat <- moreCats ) {
			if ( res.map( _.facet ) contains cat.facet )
				Log.LOGwarn( "ignore category '%s' for duplicate facet", cat.path )
			else
				res +:= cat
		}
		res.reverse.toArray
	}

	/**
	 * Search the categories up to the <code>Facet</code> for channels any their
	 * priority threshold. The first threshold found will be taken for the
	 * channel, i.e. Categories closer to the facet won't override a threshold.
	 * 
	 * @param cat
	 * @param map
	 * @return A map that gives you the threshold for each channel.
	 */
	private def chansWithPrio( cat: Category,
			                   map: mutable.Map[Channel, Short] = mutable.Map.empty[Channel, Short] ):
			    mutable.Map[Channel, Short] =
    {
		for ( chan <- cat.channels; if ( !(map contains chan) ) )
			map += (chan -> cat.prioThreshold)
		cat match {
			case sub: SubCategory => chansWithPrio( sub.parent, map )
			case _ => map
		}
    }
}
