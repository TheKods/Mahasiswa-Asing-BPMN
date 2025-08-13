package io.university.gunadarma.worker;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.Random;

@Component
public class RegistrationWorker {

    private static final Logger LOG = LoggerFactory.getLogger(RegistrationWorker.class);
    private static final String VA_PREFIX = "8881"; // Contoh prefix VA untuk Universitas Gunadarma

    @JobWorker(type = "create-payment-document", autoComplete = false)
    public void handleCreatePaymentDocument(final JobClient client, final ActivatedJob job) {
        LOG.info("Mengeksekusi 'create-payment-document'...");
        Map<String, Object> vars = job.getVariablesAsMap();
        
        // Generate dokumen pembayaran dengan VA
        String documentNumber = generatePaymentDocumentNumber();
        String virtualAccountNumber = generateVirtualAccount(vars);
        String paymentAmount = generatePaymentAmount();
        String paymentStatus = "PENDING";
        
        // Set variabel sesuai rancangan skripsi
        vars.put("paymentDocumentNumber", documentNumber);
        vars.put("virtualAccountNumber", virtualAccountNumber);
        vars.put("paymentAmount", paymentAmount);
        vars.put("paymentStatus", paymentStatus);
        
        client.newCompleteCommand(job.getKey())
              .variables(vars)
              .send()
              .join();
    }

    @JobWorker(type = "proses-verifikasi-mahasiswa", autoComplete = false)
    public void handleVerifyStudent(final JobClient client, final ActivatedJob job) {
        LOG.info("Memproses verifikasi mahasiswa...");
        Map<String, Object> vars = job.getVariablesAsMap();
        
        // Logika verifikasi mahasiswa
        boolean verificationStatus = verifyStudentData(vars);
        
        // Tambahkan variabel hasil verifikasi
        vars.put("verificationStatus", verificationStatus ? "VERIFIED" : "REJECTED");
        vars.put("message", verificationStatus ? "Verifikasi berhasil" : "Verifikasi gagal");
        
        client.newCompleteCommand(job.getKey())
              .variables(vars)
              .send()
              .join();
    }

    @JobWorker(type = "Verifikasi-Email", autoComplete = false)
    public void handleEmailVerification(final JobClient client, final ActivatedJob job) {
        LOG.info("Memverifikasi email...");
        Map<String, Object> vars = job.getVariablesAsMap();
        
        // Logika verifikasi email
        boolean emailVerified = verifyEmail(vars);
        String verificationToken = generateVerificationToken();
        
        client.newCompleteCommand(job.getKey())
              .variables(Map.of(
                  "emailVerificationStatus", emailVerified ? "VERIFIED" : "FAILED",
                  "verificationToken", verificationToken
              ))
              .send()
              .join();
    }

    @JobWorker(type = "Periksa_Informasi_Akun", autoComplete = false)
    public void handleAccountInformationCheck(final JobClient client, final ActivatedJob job) {
        LOG.info("Memeriksa informasi akun...");
        Map<String, Object> vars = job.getVariablesAsMap();
        
        // Logika pemeriksaan informasi akun
        boolean accountValid = validateAccountInformation(vars);
        
        client.newCompleteCommand(job.getKey())
              .variables(Map.of(
                  "accountValidationStatus", accountValid ? "VALID" : "INVALID",
                  "validationErrorMessage", accountValid ? null : "Informasi akun tidak valid"
              ))
              .send()
              .join();
    }

    @JobWorker(type = "Redirect_Setelah_Pendaftaran", autoComplete = false)
    public void handleRedirectAfterRegistration(final JobClient client, final ActivatedJob job) {
        LOG.info("Melakukan redirect setelah pendaftaran...");
        Map<String, Object> vars = job.getVariablesAsMap();
        
        // Logika redirect
        boolean redirectSuccessful = performRedirect(vars);
        
        client.newCompleteCommand(job.getKey())
              .variables(Map.of(
                  "redirectSuccessful", redirectSuccessful,
                  "authAction", redirectSuccessful ? "LOGIN" : "ERROR"
              ))
              .send()
              .join();
    }
    // Metode utilitas
    private String generatePaymentDocumentNumber() {
        return "DOC-" + System.currentTimeMillis();
    }

    private String generateVirtualAccount(Map<String, Object> registrationData) {
        return VA_PREFIX + new Random().nextInt(10000);
    }

    private String generatePaymentAmount() {
        return "1500000"; // nominal simulasi
    }

    private boolean verifyStudentData(Map<String, Object> data) {
        // Implementasi sederhana
        return data != null && !data.isEmpty();
    }

    private boolean verifyEmail(Map<String, Object> emailData) {
        // Implementasi sederhana
        return emailData != null && emailData.containsKey("email");
    }

    private String generateVerificationToken() {
        return "TOKEN-" + System.currentTimeMillis();
    }

    private boolean validateAccountInformation(Map<String, Object> accountInfo) {
        // Implementasi sederhana
        return accountInfo != null && accountInfo.containsKey("email");
    }

    private boolean performRedirect(Map<String, Object> redirectData) {
        // Implementasi sederhana
        return redirectData != null && redirectData.containsKey("email");
    }
}