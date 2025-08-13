package io.university.gunadarma.controller.api;

import io.university.gunadarma.entity.Pendaftaran;
import io.university.gunadarma.repository.PendaftaranRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardApiController {

	private final PendaftaranRepository pendaftaranRepository;

	public DashboardApiController(PendaftaranRepository pendaftaranRepository) {
		this.pendaftaranRepository = pendaftaranRepository;
	}

	@GetMapping("/stats")
	public Map<String, Object> getStats() {
		List<Pendaftaran> all = pendaftaranRepository.findAll();

		Map<String, Object> result = new HashMap<>();
		result.put("total", all.size());

		Map<String, Long> byStatus = all.stream()
			.collect(Collectors.groupingBy(Pendaftaran::getStatus, Collectors.counting()));
		result.put("byStatus", byStatus);

		DateTimeFormatter ym = DateTimeFormatter.ofPattern("yyyy-MM");
		Map<String, Long> perMonth = all.stream()
			.filter(p -> p.getTanggalDaftar() != null)
			.collect(Collectors.groupingBy(p -> ym.format(p.getTanggalDaftar()), Collectors.counting()));
		result.put("perMonth", perMonth);

		Map<String, Long> countries = all.stream()
			.filter(p -> p.getNegara() != null && !p.getNegara().isBlank())
			.collect(Collectors.groupingBy(p -> p.getNegara().toUpperCase(Locale.ROOT), Collectors.counting()));
		result.put("countries", countries);

		return result;
	}
} 