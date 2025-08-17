document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("pautaForm");

    form.addEventListener("submit", async (e) => {
        e.preventDefault();

        const titulo = document.getElementById("titulo").value;
        const descricao = document.getElementById("descricao").value;

        try {
            const response = await fetch("http://localhost:8080/pauta", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({ titulo, descricao })
            });

            if (response.ok) {
                alert("Pauta cadastrada com sucesso!");
                window.location.href = "pautas.html";
            } else {
                const text = await response.text();
                alert("Erro ao cadastrar pauta: " + text);
            }
        } catch (err) {
            console.error(err);
            alert("Erro ao conectar com o servidor.");
        }
    });
});