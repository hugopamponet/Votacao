document.addEventListener("DOMContentLoaded", async () => {
    const tbody = document.getElementById("pautaTableBody");
    const timers = []; // Array para controlar os timers

    try {
        const response = await fetch("http://localhost:8080/pauta/listar");
        if (!response.ok) throw new Error("Erro ao carregar pautas");

        const pautas = await response.json();

        pautas.forEach(p => {
            const row = document.createElement("tr");

            // Coluna: Pauta
            const tdPauta = document.createElement("td");
            tdPauta.textContent = p.titulo;

            // Coluna: Descrição
            const tdDescricao = document.createElement("td");
            tdDescricao.textContent = p.descricao;

            // Coluna: Tempo
            const tdTempo = document.createElement("td");

            // Coluna: Status
            const tdStatus = document.createElement("td");
            tdStatus.textContent = p.status;

            // Se estiver aberta, calcula contagem regressiva
            if (p.status === "Aberta") {
                const inicio = parseDate(p.tempoPautaFormatado);
                if (isNaN(inicio.getTime())) {
                    tdTempo.textContent = "Erro no horário";
                } else {
                    // Duração de 1 minuto (60 segundos)
                    const fim = new Date(inicio.getTime() + 1 * 60 * 1000);
                    let restante = Math.floor((fim - new Date()) / 1000);
                    if (restante < 0) restante = 0;

                    tdTempo.textContent = formatTime(restante);

                    // Armazena o timer para atualizar a cada segundo
                    timers.push({ cell: tdTempo, remaining: restante, statusCell: tdStatus });
                }
            } else {
                tdTempo.textContent = "-";
            }

            // Adiciona as células na linha
            row.appendChild(tdPauta);
            row.appendChild(tdDescricao);
            row.appendChild(tdTempo);
            row.appendChild(tdStatus);
            tbody.appendChild(row);
        });

        // Atualiza os timers a cada segundo
        setInterval(() => {
            timers.forEach(timer => {
                if (timer.remaining > 0) {
                    timer.remaining--;
                    timer.cell.textContent = formatTime(timer.remaining);
                } else {
                    timer.cell.textContent = "-";
                    timer.statusCell.textContent = "Encerrada";
                }
            });
        }, 1000);

    } catch (err) {
        console.error(err);
        alert("Erro ao carregar pautas");
    }
});

// Função para formatar segundos em "Xm Ys restantes"
function formatTime(seconds) {
    const min = Math.floor(seconds / 60);
    const sec = seconds % 60;
    return `${min}m ${sec.toString().padStart(2, '0')}s restantes`;
}

// Função para tratar datas enviadas pelo backend (ISO 8601)
function parseDate(dateString) {
    if (!dateString) return new Date(NaN);
    return new Date(dateString);
}
