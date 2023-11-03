document.querySelectorAll(".payment-input").forEach(input => input.addEventListener("input", cardValidator));

const paymentEyeIcons = document.querySelectorAll(".payment-eye");

paymentEyeIcons.forEach(icon => icon.addEventListener("click", icons));

function icons(e) {
    console.log(e.target.dataset.id)
    document.querySelectorAll(`[data-id="${e.target.dataset.id}"]`).forEach(element => element.classList.toggle("hidden"))
}
function cardValidator(e) {
    const dataset = e.target.dataset;
    const isNumber = !isNaN(
        Number(e.target.value.charAt(e.target.value.length - 1))
    );
    const isCardNum = typeof dataset.cardnumber != "undefined";
    const length = isCardNum ? 16 : 4;
    const regexFirst = isCardNum ? /(\d{4})(?=\d)/g : /(\d{2})(?=\d)/g;
    const regexSecond = isCardNum ? "$1-" : "$1/";
    const number = e.target.value.replace(/[/-]/g, "");

    if (!isNumber || number.length > length) {
        e.target.value = e.target.value.slice(0, e.target.value.length - 1);
    }
    if (typeof dataset.cardcvv == "undefined")
        e.target.value = e.target.value.replace(regexFirst, regexSecond);
}
