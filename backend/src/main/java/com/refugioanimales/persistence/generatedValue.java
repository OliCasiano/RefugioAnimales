package com.refugioanimales.persistence;

import jakarta.persistence.GenerationType;

public @interface generatedValue {

    GenerationType strategy();

}
