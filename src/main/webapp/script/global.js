const modalButtons = document.querySelectorAll("[data-modalOpen]");
const modals = document.querySelectorAll(".modal");
const closeButton = document.querySelectorAll("[data-close]");
const signUpButton = document.querySelector("[data-openRegister]");
const eyeIcons = document.querySelectorAll(".icon-eye");
const creditCards = document.querySelectorAll(".credit-card-box ");
const accountRight = document.querySelectorAll("[data-accountRight]");
try {

signUpButton.addEventListener("click", closeLoginOpenRegister);
closeButton.forEach((close) => close.addEventListener("click", closeModal));
modals.forEach((modal) => modal.addEventListener("click", closeModal));
modalButtons.forEach((button) => button.addEventListener("click", openModal));
eyeIcons.forEach(icon => icon.addEventListener("click", togglePassword));
} catch (e) {

}
try {
    accountRight.forEach(button => button.addEventListener("click", toggleInfo));
    modalButtons.forEach((button) => button.addEventListener("click", openModal));
    closeButton.forEach((close) => close.addEventListener("click", closeModal));
    modals.forEach((modal) => modal.addEventListener("click", closeModal));

} catch (e) {}
try {
    eyeIcons.forEach(icon => icon.addEventListener("click", togglePassword));

} catch (e) {}
// creditCards.forEach(card => card.addEventListener("mouseover", rotateCard));
// function rotateCard(e) {
//     let currentEl = e.target;
//     while(!currentEl.classList.contains("credit-card-box")) {
//         currentEl = currentEl.parentElement;
//     }
// }
function toggleInfo(e) {
    document.querySelectorAll(".grid-right").forEach(section => section.classList.toggle("hidden"))
    accountRight.forEach(button => {
        button.toggleAttribute("disabled")
    });
}
function togglePassword(e) {
    let parentElement = e.target.parentElement;
    for (let i = 0; i < parentElement.children.length; i++) {
        let child = parentElement.children[i];
        if(child instanceof HTMLInputElement) {
            child.type = child.type === "password" ? "text" : "password"
        } else if(child instanceof HTMLImageElement) {
            child.classList.toggle("hidden");
        }
    }
}
function closeLoginOpenRegister(e) {
    if(typeof e.target.dataset.openRegister !== "undefined") return
    e.preventDefault();
    document
        .querySelector("#login")
        .classList.add("hidden");
    document
        .querySelector("#register")
        .classList.remove("hidden");
}
function openModal(e) {
    // if(!e.target.dataset.navButton) return;
    e.preventDefault();
    document
        .querySelector(`#${e.target.dataset.type}`)
        .classList.remove("hidden");
}
function closeModal(e) {
    if(!(e.target instanceof HTMLFormElement || typeof e.target.dataset.close !== "undefined")) return;
    e.preventDefault();
    // e.stopPropagation();
    document.querySelectorAll(".modal").forEach(modal => modal.classList.add("hidden"));
    document.querySelectorAll("input").forEach(input => {
        input.value = "";
    })
}

document.addEventListener("keydown", function(event) {
    if (event.key === "Escape" || event.key === "Esc" || event.keyCode === 27) {
        document.querySelectorAll(".modal").forEach(modal => modal.classList.contains("hidden") & modal.classList.add("hidden"));
    } else if(event.key === "Enter") {
        document.querySelectorAll(".modal").forEach(modal => {
            if(!modal.classList.contains("hidden"))  modal.submit();
        })
    }
});

