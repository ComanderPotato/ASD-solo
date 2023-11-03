const MESSAGE_LENGTH = 200;

document.getElementById("message").addEventListener("input", (e) => {
    document.getElementById("char-total").textContent = e.target.value.length;
    document.getElementById("support-button").toggleAttribute("disabled", e.target.value.length > MESSAGE_LENGTH);
})
