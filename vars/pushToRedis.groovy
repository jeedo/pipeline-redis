@Grab('redis.clients:jedis:2.1.0')
import redis.clients.jedis.*

@NonCPS
def rstart() {
    def pool = new JedisPool(new JedisPoolConfig(), "redis");
    def jedis = pool.getResource()
    jedis.set("jobs:blah:start", new Date().getTime().toString() )
}

@NonCPS
def rend() {
    def pool = new JedisPool(new JedisPoolConfig(), "redis");
    def jedis = pool.getResource()
    jedis.set("jobs:blah:end", new Date().getTime().toString() )
}   
