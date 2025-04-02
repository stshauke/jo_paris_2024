document.addEventListener('DOMContentLoaded', () => {
  // Intercepter tous les clics sur les liens vers /achat
  document.addEventListener('click', (e) => {
    const target = e.target.closest('a');
    if (target && target.getAttribute('href') === '/achat') {
      e.preventDefault();
      
      const token = localStorage.getItem('jwtToken');
      
      // Créer une requête fetch avec l'en-tête Authorization
      fetch('/achat', {
        headers: {
          'Authorization': `Bearer ${token}`
        }
      })
      .then(response => {
        if (response.redirected) {
          window.location.href = response.url;
        } else if (response.ok) {
          return response.text().then(html => {
            document.open();
            document.write(html);
            document.close();
            history.pushState({}, '', '/achat');
          });
        } else if (response.status === 401) {
          window.location.href = '/connexion';
        }
      });
    }
  });
});