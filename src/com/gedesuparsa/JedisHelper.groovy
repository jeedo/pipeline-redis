package com.gedesuparsa

@Grab('redis.clients:jedis:2.1.0')
import redis.clients.jedis.*

class JedisHelper {
    def script
    def pool
    def connstr

    def JedisHelper(script, connstr) {
        this.script = script
        this.connstr = connstr
        pool = new JedisPool(new JedisPoolConfig(), connstr);
    }

    @NonCPS
    def start() {
        jedis = pool.getResource()
        jedis.set("jobs:blah:start", new Date().getTime().toString() )
    }
    @NonCPS
    def end() {
        jedis = pool.getResource()
        jedis.set("jobs:blah:end", new Date().getTime().toString() )
    }   
}