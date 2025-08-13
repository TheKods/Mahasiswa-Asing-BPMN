/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/main/resources/templates/**/*.{html,js}",
    "./src/main/resources/static/**/*.{html,js}",
  ],
  darkMode: "class",
  theme: {
    extend: {
      colors: {
        // Warna Universitas Gunadarma
        gunadarma: {
          blue: "#0066CC",
          red: "#CC0000",
          gray: {
            light: "#F5F5F5",
            dark: "#333333",
          },
        },
        // Palet warna yang ramah aksesibilitas
        accessible: {
          primary: "#1A5F7A",
          secondary: "#159895",
          accent: "#57C5B6",
          text: {
            dark: "#000000",
            light: "#FFFFFF",
          },
        },
      },
      fontFamily: {
        sans: ["Inter", "system-ui", "sans-serif"],
      },
      // Konfigurasi fokus untuk aksesibilitas
      ringWidth: {
        3: "3px",
      },
      ringColor: {
        focus: "#4299E1",
      },
      // Animasi transisi
      transitionProperty: {
        colors: "background-color, border-color, color, fill, stroke",
      },
    },
  },
  plugins: [
    require("@tailwindcss/forms"),
    require("@tailwindcss/typography"),
    require("@tailwindcss/aspect-ratio"),
    // Plugin kustom untuk aksesibilitas
    function ({ addBase, theme }) {
      addBase({
        // Tingkatkan kontras untuk mode gelap
        ".dark": {
          "--tw-text-opacity": "0.9",
          "--tw-bg-opacity": "0.9",
        },
        // Gaya fokus yang lebih jelas
        "*:focus": {
          outline: `3px solid ${theme("colors.blue.500")}`,
          "outline-offset": "2px",
        },
      });
    },
  ],
};
