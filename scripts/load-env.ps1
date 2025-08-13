param(
	[string]$EnvFilePath = ".env"
)

if (!(Test-Path -Path $EnvFilePath)) {
	Write-Error "File $EnvFilePath tidak ditemukan. Pastikan path benar."
	exit 1
}

Get-Content -Path $EnvFilePath | ForEach-Object {
	$line = $_.Trim()
	if ([string]::IsNullOrWhiteSpace($line)) { return }
	if ($line.StartsWith('#')) { return }
	# Hilangkan prefix 'export ' jika ada (Linux style)
	if ($line.StartsWith('export ')) { $line = $line.Substring(7) }
	# Hilangkan prefix 'env:' jika ada (PowerShell style dari input sebelumnya)
	if ($line.StartsWith('env:')) { $line = $line.Substring(4) }
	# Split hanya pada '=' pertama
	$idx = $line.IndexOf('=')
	if ($idx -lt 1) { return }
	$key = $line.Substring(0, $idx).Trim()
	$value = $line.Substring($idx + 1).Trim()
	# Hapus quote pembungkus jika ada
	if (($value.StartsWith('"') -and $value.EndsWith('"')) -or ($value.StartsWith("'") -and $value.EndsWith("'"))) {
		$value = $value.Substring(1, $value.Length - 2)
	}
	# Set environment variable pada proses saat ini
	[System.Environment]::SetEnvironmentVariable($key, $value, [System.EnvironmentVariableTarget]::Process)
	Write-Output "Set $key"
}

Write-Output "Selesai memuat environment dari $EnvFilePath" 