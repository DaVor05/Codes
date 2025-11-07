document.getElementById('terms').addEventListener('change', function() {
    document.getElementById('submitBtn').disabled = !this.checked;
});
