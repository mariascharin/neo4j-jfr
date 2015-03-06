/**
 * Copyright (c) 2002-2014 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This file is part of Neo4j.
 *
 * Neo4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.neo4j.kernel.monitoring.tracing.jfr;

import org.neo4j.io.pagecache.tracing.PageCacheTracer;
import org.neo4j.io.pagecache.tracing.jfr.JfrPageCacheTracer;
import org.neo4j.kernel.impl.transaction.tracing.TransactionTracer;
import org.neo4j.kernel.impl.transaction.tracing.jfr.JfrTransactionTracer;
import org.neo4j.kernel.monitoring.tracing.TracerFactory;

/**
 * This class exist to delay the initialisation of the JFR mechanics, until it's
 * been determined with certainty that they are needed.
 */
public class JfrTracerFactory implements TracerFactory
{
    @Override
    public String getImplementationName()
    {
        return "jfr";
    }

    @Override
    public PageCacheTracer createPageCacheTracer()
    {
        return new JfrPageCacheTracer();
    }

    @Override
    public TransactionTracer createTransactionTracer()
    {
        return new JfrTransactionTracer();
    }
}