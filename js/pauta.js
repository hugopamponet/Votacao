document.addEventListener("DOMContentLoaded", async () => {
    const tbody = document.getElementById("pautaTableBody");
    const timers = [];

    try {
        const response = await fetch("http://localhost:8080/pauta/listar");
        if (!response.ok) throw new Error("Erro ao carregar pautas");

        const pautas = await response.json();

        pautas.forEach(p => {
            const row = document.createElement("tr");

            const tdPauta = document.createElement("td");
            tdPauta.textContent = p.titulo;

            const tdDescricao = document.createElement("td");
            tdDescricao.textContent = p.descricao;

            const tdTempo = document.createElement("td");

            const tdStatus = document.createElement("td");
            tdStatus.textContent = p.status;

            if (p.status === "Aberta") {
                if (p.tempoRestante <= 0) {
                    tdTempo.textContent = "Tempo esgotado";
                    tdStatus.textContent = "Encerrada";
                } else {
                    tdTempo.textContent = formatTime(p.tempoRestante);

                    timers.push({ 
                        cell: tdTempo, 
                        remaining: p.tempoRestante, 
                        statusCell: tdStatus 
                    });
                }
            } else {
                tdTempo.textContent = "-";
            }

            row.appendChild(tdPauta);
            row.appendChild(tdDescricao);
            row.appendChild(tdTempo);
            row.appendChild(tdStatus);
            tbody.appendChild(row);
        });

        setInterval(() => {
            timers.forEach(timer => {
                if (timer.remaining > 0) {
                    timer.remaining--;
                    timer.cell.textContent = formatTime(timer.remaining);
                } else {
                    timer.cell.textContent = "Tempo esgotado";
                    timer.statusCell.textContent = "Encerrada";
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