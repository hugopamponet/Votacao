document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("loginForm");

    form.addEventListener("submit", async (event) => {
        event.preventDefault();

        const user = document.getElementById("usuario").value;
        const password = document.getElementById("senha").value;

        try {
            const response = await fetch("http://localhost:8080/portal/login", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ usuario: user, senha: password })
            });

            const message = await response.text();

            if (response.ok) {
                window.location.href = "index.html";
            } else {
                alert(message);
            }
        } catch (error) {
            alert("Erro ao conectar com a API");
            console.error(error);
        }
    });
});