const navButtons = document.querySelectorAll("[data-navButton]");
const modals = document.querySelectorAll(".modal");
const closeButton = document.querySelectorAll("[data-close]");
// const signUpButton = document.querySelector("[data-openRegister]");

// signUpButton.addEventListener("click", openRegister);
closeButton.forEach((close) => close.addEventListener("click", closeModal));
modals.forEach((modal) => modal.addEventListener("click", closeModal));
navButtons.forEach((button) => button.addEventListener("click", openModal));

function openRegister(e) {
    e.preventDefault();
    document
        .querySelector("#login")
        .classList.add("hidden");
    document
        .querySelector("#register")
        .classList.remove("hidden");
}
function openModal(e) {
    e.preventDefault();
    document
        .querySelector(`#${e.target.dataset.type}`)
        .classList.remove("hidden");
}
function closeModal(e) {
    e.preventDefault();
    if (e.target.id === "login" || e.target.id === "register") {
        document.querySelector(`#${e.target.id}`).classList.add("hidden");
    } else if (e.target.dataset.close) {
        document
            .querySelector(`#${e.target.dataset.close}`)
            .classList.add("hidden");
    }
}
