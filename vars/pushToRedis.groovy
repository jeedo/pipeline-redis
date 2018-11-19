@Grab('redis.clients:jedis:2.1.0')
import redis.clients.jedis.*

@NonCPS
def rstart(script) {
    def pool = new JedisPool(new JedisPoolConfig(), "redis");
    jedis = pool.getResource()
    jedis.set("jobs:blah:start", new Date().getTime().toString() )
}

@NonCPS
def rend(script) {
    def pool = new JedisPool(new JedisPoolConfig(), "redis");
    jedis = pool.getResource()
    jedis.set("jobs:blah:end", new Date().getTime().toString() )
}   
