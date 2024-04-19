package cs489.apsd.lab11_2.dto.address;

public record AddressResponse(
        Integer addressId,
        String street,
        String city,
        String state,
        String postalcode,
        String country
) {
}
