# Frontend Enhancement

## Teknologi Frontend

### Kerangka Kerja

- **Templating**: Thymeleaf
- **CSS**: Tailwind CSS
- **JavaScript**: Alpine.js
- **Aksesibilitas**: Axe Core

## Mode Gelap (Dark Mode)

### Fitur

- Toggle mode gelap dengan tombol
- Penyimpanan preferensi mode di localStorage
- Transisi warna halus
- Dukungan sistem operasi

### Implementasi

- Menggunakan kelas `dark` dari Tailwind CSS
- Tombol toggle dengan ikon matahari/bulan
- Transisi warna dengan `transition-colors`

## Aksesibilitas WCAG

### Standar

- Level Kepatuhan: WCAG 2.1 Level AA
- Audit menggunakan Axe Core

### Fitur Utama

- Kontras warna yang memadai
- Navigasi keyboard
- Skip to main content link
- Focus styles yang jelas
- ARIA attributes

### Konfigurasi

- File konfigurasi `.axe-core.json`
- Aturan aksesibilitas kritis
- Pengecualian dan pengaturan spesifik

## Responsivitas

### Desain

- Mobile-first
- Grid dan flexbox dari Tailwind
- Breakpoint responsif
- Adaptasi untuk berbagai ukuran layar

## Animasi dan Transisi

### Prinsip

- Animasi ringan
- Transisi halus
- Menghormati preferensi pengguna

### Contoh

- Dark mode toggle
- Hover states
- Focus states

## Struktur Proyek

```
src/
├── main/
│   ├── resources/
│   │   ├── static/
│   │   │   └── css/
│   │   │       └── tailwind.css
│   │   └── templates/
│   │       ├── base.html
│   │       └── components/
└── tailwind.config.js
```

## Panduan Kontribusi

### Prinsip

- Prioritaskan aksesibilitas
- Gunakan semantic HTML
- Uji di berbagai perangkat
- Perhatikan kinerja

### Alat Pengembangan

- Browser DevTools
- Axe Core
- WAVE Evaluation Tool
- Lighthouse

## Sumber Daya

- [Tailwind CSS Dokumentasi](https://tailwindcss.com/docs)
- [WCAG Guidelines](https://www.w3.org/WAI/standards-guidelines/wcag/)
- [Axe Core Dokumentasi](https://www.deque.com/axe/)

## Rencana Pengembangan

- [ ] Implementasi mode kontras tinggi
- [ ] Dukungan bahasa kanan-ke-kiri (RTL)
- [ ] Integrasi pembaca layar
- [ ] Optimasi kinerja frontend
