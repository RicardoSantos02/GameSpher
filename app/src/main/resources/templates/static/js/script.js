/* src/main/resources/static/js/script.js */

/**
 * Aplica máscara de CPF no input
 * Formato: 000.000.000-00
 */
function maskCpf(input) {
    let value = input.value.replace(/\D/g, ''); // Remove tudo que não for dígito
    value = value.replace(/(\d{3})(\d)/, '$1.$2');
    value = value.replace(/(\d{3})(\d)/, '$1.$2');
    value = value.replace(/(\d{3})(\d{1,2})$/, '$1-$2');
    input.value = value;
}

/**
 * Aplica máscara de Telefone no input
 * Suporta 8 ou 9 dígitos. Ex: (99) 99999-9999
 */
function maskPhone(input) {
    let value = input.value.replace(/\D/g, ''); // Remove tudo que não for dígito
    if (value.length > 10) { // Para números com 9 dígitos (celular)
        value = value.replace(/^(\d\d)(\d{5})(\d{4}).*/, '($1) $2-$3');
    } else if (value.length > 5) { // Para números com 8 dígitos (fixo)
        value = value.replace(/^(\d\d)(\d{4})(\d{0,4}).*/, '($1) $2-$3');
    } else if (value.length > 2) { // Apenas DDD
        value = value.replace(/^(\d\d)(\d)/, '($1) $2');
    } else { // Menos de 2 dígitos
        value = value.replace(/^(\d*)/, '($1');
    }
    input.value = value;
}