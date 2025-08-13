# Internasionalisasi (i18n)

## Dukungan Bahasa

### Bahasa yang Didukung

- 🇮🇩 Indonesia (Default)
- 🇬🇧 Inggris

## Cara Mengubah Bahasa

### Melalui Parameter URL

```
http://localhost:8080/endpoint?lang=en
http://localhost:8080/endpoint?lang=id
```

### Contoh Penggunaan di Kode

```java
@Autowired
private MessageSource messageSource;

public String getLocalizedMessage(String code, Locale locale) {
    return messageSource.getMessage(code, null, locale);
}
```

## Struktur Resource Bundle

```
src/main/resources/i18n/
├── messages_id.properties
└── messages_en.properties
```

### Format Kunci Pesan

- Gunakan format `kategori.kunci`
- Contoh: `validation.email.required`

## Praktik Terbaik

### Validasi

- Gunakan anotasi `@Size`
- Sediakan pesan kesalahan yang dapat diterjemahkan

```java
@Size(min = 8, message = "{validation.password.length}")
private String password;
```

### Pengaturan Locale

```java
@Bean
public LocaleResolver localeResolver() {
    SessionLocaleResolver slr = new SessionLocaleResolver();
    slr.setDefaultLocale(new Locale("id", "ID"));
    return slr;
}
```

## Dukungan RTL (Opsional)

- Tambahkan dukungan bahasa kanan-ke-kiri
- Gunakan CSS untuk penyesuaian tata letak

## Pemeliharaan

- Perbarui file `.properties` untuk menambah/mengubah terjemahan
- Gunakan alat penerjemahan profesional
- Lakukan tinjauan manual

## Alat Bantu

- Spring Framework MessageSource
- ResourceBundleMessageSource
- LocaleChangeInterceptor
