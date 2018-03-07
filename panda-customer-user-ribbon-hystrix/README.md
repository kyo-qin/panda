***Command Properties***
* Execution
* execution.isolation.strategy （执行的隔离策略）
* execution.isolation.thread.timeoutInMilliseconds
* execution.timeout.enabled
* execution.isolation.thread.interruptOnTimeout
* execution.isolation.semaphore.maxConcurrentRequests
* Fallback
* fallback.isolation.semaphore.maxConcurrentRequests
* fallback.enabled
* Circuit Breaker
* circuitBreaker.enabled （断路器开关）
* circuitBreaker.requestVolumeThreshold （断路器请求阈值）
* circuitBreaker.sleepWindowInMilliseconds（断路器休眠时间）
* circuitBreaker.errorThresholdPercentage（断路器错误请求百分比）
* circuitBreaker.forceOpen（断路器强制开启）
* circuitBreaker.forceClosed（断路器强制关闭）
* Metrics
* metrics.rollingStats.timeInMilliseconds
* metrics.rollingStats.numBuckets
* metrics.rollingPercentile.enabled
* metrics.rollingPercentile.timeInMilliseconds
* metrics.rollingPercentile.numBuckets
* metrics.rollingPercentile.bucketSize
* metrics.healthSnapshot.intervalInMilliseconds
* Request Context
* requestCache.enabled
* requestLog.enabled
* Collapser Properties
* maxRequestsInBatch
* timerDelayInMilliseconds
* requestCache.enabled
* Thread Pool Properties
* coreSize（线程池大小）
* maxQueueSize（最大队列数量）
* queueSizeRejectionThreshold （队列大小拒绝阈值）
* keepAliveTimeMinutes
* metrics.rollingStats.timeInMilliseconds
* metrics.rollingStats.numBuckets