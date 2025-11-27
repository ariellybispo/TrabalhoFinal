function confirmarExclusao(id) {
    if (confirm("Deseja excluir a publicação ID " + id + "?")) {
        window.location.href = "/excluir/" + id;
    }
}
