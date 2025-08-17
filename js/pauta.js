document.addEventListener("DOMContentLoaded", async () => {
    const tbody = document.getElementById("pautaTableBody");
    const timers = [];

    try {
        const response = await fetch("http://localhost:8080/pauta/listar");
        if (!response.ok) throw new Error("Erro ao carregar pautas");

        const pautas = await response.json();

        pautas.forEach(p => {
            const row = document.createElement("tr");

            const tdEmpresa = document.createElement("td");
            tdEmpresa.textContent = "Minha Empresa";

            const tdPauta = document.createElement("td");
            tdPauta.textContent = p.titulo;

            const tdTempo = document.createElement("td");

            if (p.status === "Aberta") {
                // Converte string ISO para Date
                const inicio = new Date(p.tempoPauta);
                if (isNaN(inicio.getTime())) {
                    tdTempo.textContent = "Erro no horário";
                } else {
                    // Duração de 1 minuto
                    const fim = new Date(inicio.getTime() + 1 * 60 * 1000);
                    let restante = Math.floor((fim - new Date()) / 1000);
                    if (restante < 0) restante = 0;

                    tdTempo.textContent = formatTime(restante);

                    timers.push({ cell: tdTempo, remaining: restante });
                }
            } else {
                tdTempo.textContent = "Encerrada";
            }

            row.appendChild(tdEmpresa);
            row.appendChild(tdPauta);
            row.appendChild(tdTempo);
            tbody.appendChild(row);
        });

        setInterval(() => {
            timers.forEach(timer => {
                if (timer.remaining > 0) {
                    timer.remaining--;
                    timer.cell.textContent = formatTime(timer.remaining);
                } else {
                    timer.cell.textContent = "Encerrada";
                }
            });
        }, 1000);

    } catch (err) {
        console.error(err);
        alert("Erro ao carregar pautas");
    }
});

function formatTime(seconds) {
    const min = Math.floor(seconds / 60);
    const sec = seconds % 60;
    return `${min}m ${sec.toString().padStart(2, '0')}s restantes`;
}
