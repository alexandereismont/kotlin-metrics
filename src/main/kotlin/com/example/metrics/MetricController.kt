package com.example.metrics

import io.micrometer.core.instrument.MeterRegistry
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MetricController(meterRegistry: MeterRegistry) {

	val accessCounter = meterRegistry.counter("controller.access.times")

	@GetMapping("/metric")
	fun metric(): Double {
		accessCounter.increment()
		return accessCounter.count()
	}

}